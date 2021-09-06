@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLElement
import react.State
import react.ReactElement

external interface IButtonProps<E : HTMLElement /* HTMLButtonElement | HTMLAnchorElement */> : IActionProps,
    IElementRefProps<E> {
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

// IAnchorButtonProps in typealiases

external interface IButtonState : State {
    var isActive: Boolean
}

abstract external class AbstractButton<E : HTMLElement /* HTMLButtonElement | HTMLAnchorElement */> :
    AbstractPureComponent2<IButtonProps<E>, IButtonState>

external class Button : AbstractButton<HTMLButtonElement> {
    override fun render(): ReactElement
}

external class AnchorButton : AbstractButton<HTMLAnchorElement> {
    override fun render(): ReactElement
}
