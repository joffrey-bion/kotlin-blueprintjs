@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*

external interface DialogFooterProps : PropsWithClassName, PropsWithChildren {

    /**
     * Dialog actions (typically buttons) are rendered on the right side of the footer.
     */
    var actions: ReactNode?

    /**
     * Use a "minimal" appearance for the footer, simply applying an HTML role and
     * some visual padding. This is useful for small dialogs, and should not be used
     * with `<DialogBody useOverflowScrollContainer>`.
     *
     * Note that this is the default behavior when using the CSS API, since that's
     * how the `-dialog-footer` class was first introduced, so these styles are
     * applied without a "modifier" class.
     *
     * When using the JS component API, `minimal` is false by default.
     *
     * Show the footer close from the content.
     * Do not use with scroll body
     * Use for small dialogs (confirm)
     *
     * @default false;
     */
    var minimal: Boolean?
}

/**
 * Dialog footer component.
 *
 * @see https://blueprintjs.com/docs/#core/components/dialog.dialog-footer-props
 */
external class DialogFooter : AbstractPureComponent2<DialogFooterProps, State> {
    override fun render(): ReactElement<DialogFooterProps>
}
