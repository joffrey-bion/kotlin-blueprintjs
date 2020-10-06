package org.hildan.dukat

fun String.fixDukatOutput(): String =
    fixConstructorTypeParameter().fixInitializedValues().fixIElementRefProps().fixPartials()

// https://github.com/Kotlin/dukat/issues/414
private fun String.fixConstructorTypeParameter(): String {
    // class FileInput(props: P = definedExternally, context: Any = definedExternally) : AbstractPureComponent2__1<IFileInputProps>
    // class Drawer(props: P = definedExternally, context: Any = definedExternally) : AbstractPureComponent2__1<IDrawerProps>
    // class Icon(props: P = definedExternally, context: Any = definedExternally) : AbstractPureComponent2__1<IIconProps>
    // class Breadcrumbs(props: P, context: Any = definedExternally) : AbstractPureComponent2__1<IBreadcrumbsProps> {
    // class AbstractButton<H : HTMLAttributes<HTMLElement>>(props: P, context: Any = definedExternally) : AbstractPureComponent2__2<IButtonProps /* IButtonProps & H */, IButtonState> {
    // class Button(props: P = definedExternally, context: Any = definedExternally) : AbstractButton<ButtonHTMLAttributes<HTMLButtonElement>> {
    // class Button(props: P, context: Any = definedExternally) : AbstractButton<ButtonHTMLAttributes<HTMLButtonElement>> {
    return replace(
        regex = Regex(
            """class ([^)]+)\(props: P( = definedExternally)?, context: Any = definedExternally\)\s*:\s*AbstractPureComponent2__1<([^/>]+(/\*[^*]+\*/)?)>"""),
        replacement = "class $1(props: $3$2, context: Any = definedExternally): AbstractPureComponent2__1<$3>"
    ).replace(
        regex = Regex("""class ([^)]+)\(props: P( = definedExternally)?, context: Any = definedExternally\)\s*:\s*AbstractPureComponent2__2<([^,]+)\s*(,\s*[^,]+\s*)?>"""),
        replacement = "class $1(props: $3$2, context: Any = definedExternally): AbstractPureComponent2__2<$3$4>"
    ).replace(
        regex = Regex("""class ([^)]+)\(props: P( = definedExternally)?, context: Any = definedExternally\)\s*:\s*AbstractButton<([^</>]+(<[^>]+>)?)(/\*[^*]+\*/)?>"""),
        replacement = "class $1(props: $3$2, context: Any = definedExternally): AbstractButton<$3$5>"
    )
}

// https://github.com/Kotlin/dukat/issues/415
private fun String.fixInitializedValues(): String {
    // var SIZE_SMALL: Any = 20
    // var SIZE_SMALL: Any = "360px"
    return replace(
        regex = Regex("""(va[rl])\s+(\w+)\s*:\s*(\w+)\s*=\s*((\d+)|("[^"]*"))"""),
        replacement = "$1 $2: $3 = definedExternally"
    )
}

private fun String.fixIElementRefProps(): String {
    // IElementRefProps<any> is translated to IElementRefProps<Any> but the type param must extend HTMLElement
    return replace(
        regex = Regex("""IElementRefProps<Any>"""),
        replacement = "IElementRefProps<HTMLElement>"
    )
}

// https://github.com/Kotlin/dukat/issues/416
private fun String.fixPartials(): String {
    // these interfaces only contains nullable properties anyway, so there is no need for their -Partial version
    return replace("""IPropsPartial""", "IProps")
        .replace("IIntentPropsPartial", "IIntentProps")
        .replace("IPopoverSharedPropsPartial", "IPopoverSharedProps")
}
