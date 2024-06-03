@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import js.objects.*
import react.*
import react.dom.events.*
import web.html.*

/**
 * Public instance properties & methods for an overlay in the current overlay stack.
 */
external interface OverlayInstance {
    /**
     * Bring document focus inside this overlay element.
     * This should be defined if `props.enforceFocus={true}` or `props.autoFocus={true}`.
     */
    var bringFocusInsideOverlay: (() -> Unit)?

    /** Reference to the overlay container element which may or may not be in a Portal. */
    var containerElement: RefObject<HTMLDivElement>
    /**
     * Document "focus" event handler which needs to be attached & detached appropriately.
     * This should be defined if `props.enforceFocus={true}`.
     */
    var handleDocumentFocus: FocusEventHandler<*>?
    /**
     * Document "mousedown" event handler which needs to be attached & detached appropriately.
     * This should be defined if `props.canOutsideClickClose={true}` and `props.hasBackdrop={false}`.
     */
    var handleDocumentMousedown: MouseEventHandler<*>?
    /** Unique ID for this overlay which helps to identify it across prop changes. */
    var id: String
    /** Subset of props necessary for some overlay stack focus management logic. */
    var props: OverlayProps // can't pick only a subset
}

external interface Overlay2Props : OverlayProps, PropsWithRef<OverlayInstance> {
    /**
     * If you provide a single child element to Overlay2 and attach your own `ref` to the node, you must pass the
     * same value here (otherwise, Overlay2 won't be able to render CSSTransition correctly).
     *
     * Mutually exclusive with the `childRefs` prop. This prop is a shorthand for `childRefs={{ [key: string]: ref }}`.
     */
    var childRef: RefObject<HTMLElement>?
    /**
     * If you provide a _multiple child elements_ to Overlay2, you must enumerate and generate a
     * collection of DOM refs to those elements and provide it here. The object's keys must correspond to the child
     * React element `key` values.
     *
     * Mutually exclusive with the `childRef` prop. If you only provide a single child element, consider using
     * `childRef` instead.
     */
    var childRefs: Record<String, RefObject<HTMLElement>>?
}

/**
 * Overlay2 component.
 *
 * https://blueprintjs.com/docs/#core/components/overlay2
 */
external val Overlay2: ForwardRefExoticComponent<Overlay2Props /* & PropsWithRef<OverlayInstance> */>
