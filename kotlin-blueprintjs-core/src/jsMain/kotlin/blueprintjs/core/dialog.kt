@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import web.html.HTMLDivElement

external interface DialogProps : OverlayableProps, BackdropProps, PropsWithClassName, PropsWithChildren {

    // 'children' is declared via PropsWithChildren

    /**
     * Toggles the visibility of the overlay and its children.
     * This prop is required because the component is controlled.
     */
    var isOpen: Boolean

    // 'hasBackdrop' cannot be overridden with Nothing (to mimic the TS 'never')
    // because it is a 'var' property.

    /**
     * Name of a Blueprint UI icon (or an icon element) to render in the
     * dialog's header. Note that the header will only be rendered if `title` is
     * provided.
     */
    var icon: dynamic /* IconName? | ReactElement? */
    /**
     * Whether to show the close button in the dialog's header.
     * Note that the header will only be rendered if `title` is provided.
     *
     * @default true
     */
    var isCloseButtonShown: Boolean?
    /**
     * CSS styles to apply to the dialog.
     * @default {}
     */
    var style: CSSProperties
    /**
     * Title of the dialog. If provided, an element with `Classes.DIALOG_HEADER`
     * will be rendered inside the dialog before any children elements.
     */
    var title: ReactNode?
    /**
     * Name of the transition for internal `CSSTransition`. Providing your own
     * name here will require defining new CSS transition properties.
     */
    var transitionName: String?

    /**
     * Ref supplied to the `Classes.DIALOG_CONTAINER` element.
     */
    var containerRef: Ref<HTMLDivElement>

    // TODO aria-labelledby and aria-describedby cannot be added here due Kotlin/JS limitation
    //   https://youtrack.jetbrains.com/issue/KT-31799
}

/**
 * Dialog component.
 *
 * https://blueprintjs.com/docs/#core/components/dialog
 */
external class Dialog : AbstractPureComponent<DialogProps, State> {
    override fun render(): ReactElement<DialogProps>
}
