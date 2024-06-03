@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.events.MouseEventHandler
import web.html.HTMLDivElement

external interface CardProps : PropsWithClassName, HTMLDivProps, PropsWithRef<HTMLDivElement> {
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
     * Whether this card should appear selected.
     *
     * @default undefined
     */
    var selected: Boolean?

    /**
     * Whether this component should use compact styles with reduced visual padding.
     *
     * @default false
     */
    var compact: Boolean?

    /**
     * Callback invoked when the card is clicked.
     * Recommended when `interactive` is `true`.
     */
    override var onClick: MouseEventHandler<HTMLDivElement>?
}

/**
 * Card component.
 *
 * https://blueprintjs.com/docs/#core/components/card
 */
external val Card : FC<CardProps>
