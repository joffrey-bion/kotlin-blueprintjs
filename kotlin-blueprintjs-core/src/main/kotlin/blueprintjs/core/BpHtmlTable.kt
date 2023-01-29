@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.PropsWithClassName
import react.ReactElement
import react.State
import react.dom.html.TableHTMLAttributes
import web.html.HTMLTableElement

// in BlueprintJS, HTMLTableProps doesn't extend IProps, and yet className works fine...
external interface HTMLTableProps : PropsWithClassName, TableHTMLAttributes<HTMLTableElement>, IElementRefProps<HTMLTableElement> {
    /** Enables borders between rows and cells. */
    var bordered: Boolean?

    /** Use compact appearance with less padding. */
    var compact: Boolean?

    @Deprecated("Deprecated in BlueprintJS, use 'compact' instead", ReplaceWith("compact"))
    var condensed: Boolean?

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
open external class HTMLTable : AbstractPureComponent2<HTMLTableProps, State> {
    override fun render(): ReactElement<HTMLTableProps>
}
