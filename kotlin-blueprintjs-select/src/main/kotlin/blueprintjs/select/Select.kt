@file:JsModule("@blueprintjs/select")

package blueprintjs.select

import blueprintjs.core.AbstractPureComponent2
import blueprintjs.core.IInputGroupProps2
import blueprintjs.core.IPopoverProps
import react.PureComponent
import react.RState
import react.ReactElement

external interface ISelectProps<T> : IListItemsProps<T> {
    /**
     * Whether the dropdown list can be filtered.
     * Disabling this option will remove the `InputGroup` and ignore `inputProps`.
     *
     * @default true
     */
    var filterable: Boolean?
    /**
     * Whether the component is non-interactive.
     * If true, the list's item renderer will not be called.
     * Note that you'll also need to disable the component's children, if appropriate.
     *
     * @default false
     */
    var disabled: Boolean?
    /**
     * Props to spread to the query `InputGroup`. Use `query` and
     * `onQueryChange` instead of `inputProps.value` and `inputProps.onChange`
     * to control this input.
     */
    var inputProps: IInputGroupProps2?
    /** Props to spread to `Popover`. Note that `content` cannot be changed. */
    var popoverProps: IPopoverProps? // Partial<IPopoverProps> & object;
    /**
     * Whether the active item should be reset to the first matching item _when
     * the popover closes_. The query will also be reset to the empty string.
     *
     * @default false
     */
    var resetOnClose: Boolean?
}

external class Select<T> : AbstractPureComponent2<ISelectProps<T>, RState> {
    override fun render(): ReactElement
}