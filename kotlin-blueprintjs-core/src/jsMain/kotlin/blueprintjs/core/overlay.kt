@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*

external interface OverlayState : State {
    var hasEverOpened: Boolean?
}

/**
 * Overlay component.
 *
 * https://blueprintjs.com/docs/#core/components/overlay
 *
 * @deprecated use `Overlay2` instead
 */
@Deprecated("use Overlay2 instead", ReplaceWith("Overlay2"))
external class Overlay : AbstractPureComponent<OverlayProps, OverlayState> {
    override fun render(): ReactElement<OverlayProps>
}
