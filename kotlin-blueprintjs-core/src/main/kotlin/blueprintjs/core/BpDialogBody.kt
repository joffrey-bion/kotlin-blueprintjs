@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*

external interface DialogBodyProps : PropsWithClassName, PropsWithChildren {

    /**
     * Enable scrolling for the container
     *
     * @default true
     */
    var useOverflowScrollContainer: Boolean?
}

/**
 * Dialog body component.
 *
 * https://blueprintjs.com/docs/#core/components/dialog.dialog-body-props
 */
external class DialogBody : AbstractPureComponent2<DialogBodyProps, State> {
    override fun render(): ReactElement<DialogBodyProps>
}
