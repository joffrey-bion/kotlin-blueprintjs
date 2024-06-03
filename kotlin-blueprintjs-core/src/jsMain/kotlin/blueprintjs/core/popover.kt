@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*

external sealed class PopoverInteractionKind {
    object CLICK : PopoverInteractionKind
    object CLICK_TARGET_ONLY : PopoverInteractionKind
    object HOVER : PopoverInteractionKind
    object HOVER_TARGET_ONLY : PopoverInteractionKind
}

external interface PopoverProps<TProps : DefaultPopoverTargetHTMLProps> : PopoverSharedProps<TProps> {
    /**
     * Whether the popover/tooltip should acquire application focus when it first opens.
     *
     * @default true for click interactions, false for hover interactions
     */
    override var autoFocus: Boolean?

    /** HTML props for the backdrop element. Can be combined with `backdropClassName`. */
    var backdropProps: PropsWithChildren? // React.HTMLProps<HTMLDivElement>

    /**
     * The content displayed inside the popover. This can instead be provided as
     * the _second_ element in `children` (first is `target`).
     */
    var content: Any? /* String? | JSX.Element? */

    /**
     * The kind of interaction that triggers the display of the popover.
     *
     * @default PopoverInteractionKind.CLICK
     */
    var interactionKind: PopoverInteractionKind?

    /**
     * The kind of popup displayed by the popover. Gets directly applied to the
     * `aria-haspopup` attribute of the target element. This property is
     * ignored if `interactionKind` is {@link PopoverInteractionKind.HOVER_TARGET_ONLY}.
     *
     * @default "menu" or undefined
     */
    var popupKind: PopupKind?

    /**
     * Enables an invisible overlay beneath the popover that captures clicks and
     * prevents interaction with the rest of the document until the popover is
     * closed. This prop is only available when `interactionKind` is
     * `PopoverInteractionKind.CLICK`. When popovers with backdrop are opened,
     * they become focused.
     *
     * @default false
     */
    var hasBackdrop: Boolean?

    /**
     * Whether the application should return focus to the last active element in the
     * document after this popover closes.
     *
     * This is automatically set to `false` if this is a hover interaction popover.
     *
     * If you are attaching a popover _and_ a tooltip to the same target, you must take
     * care to either disable this prop for the popover _or_ disable the tooltip's
     * `openOnTargetFocus` prop.
     *
     * @default false
     */
    override var shouldReturnFocusOnClose: Boolean?

    /**
     * Popper.js positioning strategy.
     *
     * https://popper.js.org/docs/v2/constructors/#strategy
     * @default "absolute"
     */
    var positioningStrategy: String? // "absolute" | "fixed"
}

external interface PopoverState : State {
    var hasDarkParent: Boolean
    var isClosingViaEscapeKeypress: String
    var isOpen: Boolean
}

/**
 * Popover component, used to display a floating UI next to and tethered to a target element.
 *
 * https://blueprintjs.com/docs/#core/components/popover
 *
 * @param T target element props interface. Consumers wishing to stay in sync with Blueprint's default target HTML
 * props interface should use the `DefaultPopoverTargetHTMLProps` type (although this is already the default type for
 * this type param).
 */
open external class Popover<T : DefaultPopoverTargetHTMLProps> : AbstractPureComponent<PopoverProps<T>, PopoverState> {
    override fun render(): ReactElement<*>
}
