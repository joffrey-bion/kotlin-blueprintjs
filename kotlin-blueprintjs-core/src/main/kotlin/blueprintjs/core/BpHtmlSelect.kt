@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import org.w3c.dom.events.Event
import react.State
import react.ReactElement

external interface IHTMLSelectProps : IProps {
    /** Whether this element is non-interactive. */
    var disabled: Boolean?

    /** Whether this element should fill its container. */
    var fill: Boolean?

    /** Props to spread to the `<Icon>` element. */
    var iconProps: IIconProps?

    /** Whether to use large styles. */
    var large: Boolean?

    /** Whether to use minimal styles. */
    var minimal: Boolean?

    /** Change event handler. Use `event.currentTarget.value` to access the new value. */
    var onChange: ((Event) -> Unit)?

    /**
     * Shorthand for supplying options: an array of basic types or
     * `{ label?, value }` objects. If no `label` is supplied, `value`
     * will be used as the label.
     */
    var options: Array<Any /* string | number | IOptionProps */>?

    /** Controlled value of this component. */
    var value: dynamic /* String | Number | null */
}

open external class HTMLSelect : AbstractPureComponent2<IHTMLSelectProps, State> {
    override fun render(): ReactElement
}
