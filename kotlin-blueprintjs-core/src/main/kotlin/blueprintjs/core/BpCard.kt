@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import org.w3c.dom.events.MouseEvent
import react.PureComponent
import react.State
import react.ReactElement

external interface ICardProps : IProps {
    /**
     * Controls the intensity of the drop shadow beneath the card: the higher
     * the elevation, the higher the drop shadow. At elevation `0`, no drop
     * shadow is applied.
     *
     * @default 0
     */
    var elevation: Elevation?

    /**
     * Whether the card should respond to user interactions. If set to `true`,
     * hovering over the card will increase the card's elevation
     * and change the mouse cursor to a pointer.
     *
     * Recommended when `onClick` is also defined.
     *
     * @default false
     */
    var interactive: Boolean?

    /**
     * Callback invoked when the card is clicked.
     * Recommended when `interactive` is `true`.
     */
    var onClick: ((e: MouseEvent) -> Unit)?
}

open external class Card : AbstractPureComponent2<ICardProps, State> {
    override fun render(): ReactElement
}
