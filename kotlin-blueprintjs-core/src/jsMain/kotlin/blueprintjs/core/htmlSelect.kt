@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import blueprintjs.icons.*
import react.*
import react.dom.events.ChangeEventHandler
import react.dom.html.SelectHTMLAttributes
import web.html.HTMLSelectElement

external interface HTMLSelectProps :
    PropsWithRef<HTMLSelectElement>,
    SelectHTMLAttributes<HTMLSelectElement>,
    PropsWithChildren
{
    // 'children' is declared via PropsWithChildren

    /** Whether this element is non-interactive. */
    override var disabled: Boolean?

    /** Whether this element should fill its container. */
    var fill: Boolean?

    /**
     * Name of one of the supported icons for this component to display on the right side of the element.
     *
     * @default "double-caret-vertical"
     */
    var iconName: dynamic // HTMLSelectIconName = Extends<IconName, "double-caret-vertical" | "caret-down">

    /** Props to spread to the `<Icon>` element. */
    var iconProps: SVGIconProps<*>?

    /** Whether to use large styles. */
    var large: Boolean?

    /** Whether to use minimal styles. */
    var minimal: Boolean?

    // can't override 'multiple' with nothing (to mimic TS's never) because it's a var

    /** Change event handler. Use `event.currentTarget.value` to access the new value. */
    override var onChange: ChangeEventHandler<HTMLSelectElement>?

    /**
     * Shorthand for supplying options: an array of basic types or
     * `{ label?, value }` objects. If no `label` is supplied, `value`
     * will be used as the label.
     */
    var options: Array<Any>? // ReadonlyArray<string | number | OptionProps>

    /** Controlled value of this component. */
    override var value: Any? /* string | number | null */
}

/**
 * HTML select component
 *
 * https://blueprintjs.com/docs/#core/components/html-select
 */
external val HTMLSelect : FC<HTMLSelectProps>
