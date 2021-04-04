@file:JsModule("@blueprintjs/select")

package blueprintjs.select

import blueprintjs.core.IInputGroupProps2
import blueprintjs.core.IOverlayProps
import react.PureComponent
import react.RState
import react.ReactElement

external interface IOmnibarProps<T> : IListItemsProps<T> {
    /**
     * Props to spread to the query `InputGroup`. Use `query` and
     * `onQueryChange` instead of `inputProps.value` and `inputProps.onChange`
     * to control this input.
     */
    var inputProps: IInputGroupProps2?
    /**
     * Toggles the visibility of the omnibar.
     * This prop is required because the component is controlled.
     */
    var isOpen: Boolean
    /**
     * A callback that is invoked when user interaction causes the omnibar to
     * close, such as clicking on the overlay or pressing the `esc` key (if
     * enabled). Receives the event from the user's interaction, if there was an
     * event (generally either a mouse or key event).
     *
     * Note that due to controlled usage, this component will not actually close
     * itself until the `isOpen` prop becomes `false`.
     * .
     */
    var onClose: ((event: org.w3c.dom.events.Event) -> Unit)?
    /** Props to spread to `Overlay`. */
    var overlayProps: IOverlayProps? // Partial<IOverlayProps>?
}

external class Omnibar<T> : PureComponent<IOmnibarProps<T>, RState> {
    override fun render(): ReactElement
}