@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.PropsWithChildren
import react.ReactElement
import react.State
import react.dom.events.ChangeEventHandler
import react.dom.html.SelectHTMLAttributes
import web.html.HTMLSelectElement

external interface IHTMLSelectProps :
    IElementRefProps<HTMLSelectElement>,
    SelectHTMLAttributes<HTMLSelectElement>,
    PropsWithChildren
{
    /** Whether this element is non-interactive. */
    override var disabled: Boolean?

    /** Whether this element should fill its container. */
    var fill: Boolean?

    /** Props to spread to the `<Icon>` element. */
    var iconProps: IconProps?

    /** Whether to use large styles. */
    var large: Boolean?

    /** Whether to use minimal styles. */
    var minimal: Boolean?

    /** Change event handler. Use `event.currentTarget.value` to access the new value. */
    override var onChange: ChangeEventHandler<HTMLSelectElement>?

    /**
     * Shorthand for supplying options: an array of basic types or
     * `{ label?, value }` objects. If no `label` is supplied, `value`
     * will be used as the label.
     */
    var options: Array<Any /* string | number | OptionProps */>?

    /** Controlled value of this component. */
    override var value: Any? /* String | Number | null */
}

/**
 * HTML select component
 *
 * https://blueprintjs.com/docs/#core/components/html-select
 */
open external class HTMLSelect : AbstractPureComponent2<IHTMLSelectProps, State> {
    override fun render(): ReactElement<IHTMLSelectProps>
}
