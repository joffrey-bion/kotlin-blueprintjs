@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.PropsWithChildren
import react.PropsWithClassName
import react.State
import react.ReactElement

external interface TextProps : PropsWithClassName, PropsWithChildren {
    /**
     * Indicates that this component should be truncated with an ellipsis if it overflows its container.
     * The `title` attribute will also be added when content overflows to show the full text of the children on hover.
     * @default false
     */
    var ellipsize: Boolean?

    /**
     * HTML tag name to use for rendered element.
     * @default "div"
     */
    var tagName: String? // keyof JSX.IntrinsicElements

    /**
     * HTML title of the element
     */
    var title: String?
}

external interface ITextState : State {
    var textContent: String
    var isContentOverflowing: Boolean
}

external class Text : AbstractPureComponent2<TextProps, ITextState> {
    override fun render(): ReactElement<TextProps>
}
