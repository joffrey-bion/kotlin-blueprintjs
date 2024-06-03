@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.html.TableHTMLAttributes
import web.html.HTMLTableElement

// in BlueprintJS, HTMLTableProps doesn't extend IProps, and yet className works fine...
external interface HTMLTableProps : PropsWithClassName, TableHTMLAttributes<HTMLTableElement>, PropsWithRef<HTMLTableElement> {
    /** Enables borders between rows and cells. */
    var bordered: Boolean?

    /** Use compact appearance with less padding. */
    var compact: Boolean?

    /** Enables hover styles on row. */
    var interactive: Boolean?

    /** Use an alternate background color on odd rows. */
    var striped: Boolean?
}

/**
 * HTML table component.
 *
 * https://blueprintjs.com/docs/#core/components/html-table
 */
external val HTMLTable : FC<HTMLTableProps>
