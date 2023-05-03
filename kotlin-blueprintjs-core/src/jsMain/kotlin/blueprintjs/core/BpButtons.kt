@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.PropsWithChildren
import react.ReactElement
import react.State
import web.html.HTMLAnchorElement
import web.html.HTMLButtonElement
import web.html.HTMLElement

external interface ButtonProps<E : HTMLElement /* HTMLButtonElement | HTMLAnchorElement */> :
    ActionProps,
    IElementRefProps<E>,
    PropsWithChildren { // artificially added PropsWithChildren so ButtonProps can be used in AbstractPureComponent2

    // artificially added to allow title on button (should probably be on more general props)
    var title: String?

    /**
     * If set to `true`, the button will display in an active state.
     * This is equivalent to setting `className={Classes.ACTIVE}`.
     * @default false
     */
    var active: Boolean?

    /**
     * Text alignment within button. By default, icons and text will be centered
     * within the button. Passing `"left"` or `"right"` will align the button
     * text to that side and push `icon` and `rightIcon` to either edge. Passing
     * `"center"` will center the text and icons together.
     * @default Alignment.CENTER
     */
    var alignText: Alignment?

    /** Whether this button should expand to fill its container. */
    var fill: Boolean?

    /** Whether this button should use large styles. */
    var large: Boolean?

    /**
     * If set to `true`, the button will display a centered loading spinner instead of its contents.
     * The width of the button is not affected by the value of this prop.
     * @default false
     */
    var loading: Boolean?

    /** Whether this button should use minimal styles. */
    var minimal: Boolean?

    /** Whether this button should use outlined styles. */
    var outlined: Boolean?

    /** Name of a Blueprint UI icon (or an icon element) to render after the text. */
    var rightIcon: dynamic /* IconName | MaybeElement */

    /** Whether this button should use small styles. */
    var small: Boolean?

    /**
     * HTML `type` attribute of button. Accepted values are `"button"`, `"submit"`, and `"reset"`.
     * Note that this prop has no effect on `AnchorButton`; it only affects `Button`.
     * @default "button"
     */
    var type: String? // "submit" | "reset" | "button";
}

// AnchorButtonProps in typealiases

external interface IButtonState : State {
    var isActive: Boolean
}

abstract external class AbstractButton<E : HTMLElement /* HTMLButtonElement | HTMLAnchorElement */> :
    AbstractPureComponent2<ButtonProps<E>, IButtonState>

/**
 * Button component.
 *
 * https://blueprintjs.com/docs/#core/components/button
 */
external class Button : AbstractButton<HTMLButtonElement> {
    override fun render(): ReactElement<ButtonProps<HTMLButtonElement>>
}

/**
 * AnchorButton component.
 *
 * https://blueprintjs.com/docs/#core/components/button
 */
external class AnchorButton : AbstractButton<HTMLAnchorElement> {
    override fun render(): ReactElement<ButtonProps<HTMLAnchorElement>>
}
