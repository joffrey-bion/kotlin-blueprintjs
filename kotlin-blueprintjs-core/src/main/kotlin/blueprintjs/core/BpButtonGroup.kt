@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.State
import react.ReactElement

external interface IButtonGroupProps : IProps, HTMLDivProps {
    /**
     * Text alignment within button. By default, icons and text will be centered
     * within the button. Passing `"left"` or `"right"` will align the button
     * text to that side and push `icon` and `rightIcon` to either edge. Passing
     * `"center"` will center the text and icons together.
     */
    var alignText: Alignment?

    /**
     * Whether the button group should take up the full width of its container.
     * @default false
     */
    var fill: Boolean?

    /**
     * Whether the child buttons should appear with minimal styling.
     * @default false
     */
    var minimal: Boolean?

    /**
     * Whether the child buttons should appear with large styling.
     * @default false
     */
    var large: Boolean?

    /**
     * Whether the button group should appear with vertical styling.
     * @default false
     */
    var vertical: Boolean?
}

external class ButtonGroup : AbstractPureComponent2<IButtonGroupProps, State> {
    override fun render(): ReactElement?
}
