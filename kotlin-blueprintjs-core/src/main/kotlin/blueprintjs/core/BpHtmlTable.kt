@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import org.w3c.dom.HTMLTableElement
import react.State
import react.ReactElement

// in BlueprintJS, IHTMLTableProps doesn't extend IProps, and yet className works fine...
external interface IHTMLTableProps : IProps, IElementRefProps<HTMLTableElement> {
    /** Enables borders between rows and cells. */
    var bordered: Boolean?

    /** Use small, condensed appearance. */
    var condensed: Boolean?

    /** Enables hover styles on row. */
    var interactive: Boolean?

    @Deprecated("Deprecated in TypeScript")
    var small: Boolean?

    /** Use an alternate background color on odd rows. */
    var striped: Boolean?
}

open external class HTMLTable : AbstractPureComponent2<IHTMLTableProps, State> {
    override fun render(): ReactElement<IHTMLTableProps>
}
