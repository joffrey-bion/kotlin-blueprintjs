@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.events.SyntheticEvent
import react.dom.html.HTMLAttributes
import web.html.*

external sealed class PopoverInteractionKind {
    object CLICK : PopoverInteractionKind
    object CLICK_TARGET_ONLY : PopoverInteractionKind
    object HOVER : PopoverInteractionKind
    object HOVER_TARGET_ONLY : PopoverInteractionKind
}

external sealed class PopoverPosition {
    object AUTO : PopoverPosition
    object AUTO_END : PopoverPosition
    object AUTO_START : PopoverPosition
    object BOTTOM : PopoverPosition
    object BOTTOM_LEFT : PopoverPosition
    object BOTTOM_RIGHT : PopoverPosition
    object LEFT : PopoverPosition
    object LEFT_BOTTOM : PopoverPosition
    object LEFT_TOP : PopoverPosition
    object RIGHT : PopoverPosition
    object RIGHT_BOTTOM : PopoverPosition
    object RIGHT_TOP : PopoverPosition
    object TOP : PopoverPosition
    object TOP_LEFT : PopoverPosition
    object TOP_RIGH : PopoverPosition
}

external interface PopoverSharedProps : OverlayableProps, PropsWithClassName, PropsWithChildren {
    /**
     * Determines the boundary element used by Popper for its `flip` and
     * `preventOverflow` modifiers. Three shorthand keywords are supported;
     * Popper will find the correct DOM element itself.
     *
     * @default "scrollParent"
     */
    var boundary: String? // PopperBoundary = 'scrollParent' | 'viewport' | 'window'
    /**
     * When enabled, clicks inside a `Classes.POPOVER_DISMISS` element
     * will only close the current popover and not outer popovers.
     * When disabled, the current popover and any ancestor popovers will be closed.
     *
     * @see http://blueprintjs.com/docs/#core/components/popover.closing-on-click
     * @default false
     */
    var captureDismiss: Boolean?
    /**
     * Initial opened state when uncontrolled.
     *
     * @default false
     */
    var defaultIsOpen: Boolean?
    /**
     * Prevents the popover from appearing when `true`.
     *
     * @default false
     */
    var disabled: Boolean?
    /**
     * The amount of time in milliseconds the popover should remain open after
     * the user hovers off the trigger. The timer is canceled if the user mouses
     * over the target before it expires.
     *
     * @default 300
     */
    var hoverCloseDelay: Long?
    /**
     * The amount of time in milliseconds the popover should wait before opening
     * after the user hovers over the trigger. The timer is canceled if the user
     * mouses away from the target before it expires.
     *
     * @default 150
     */
    var hoverOpenDelay: Long?
    /**
     * Whether a popover that uses a `Portal` should automatically inherit the
     * dark theme from its parent.
     *
     * @default true
     */
    var inheritDarkTheme: Boolean?
    /**
     * Whether the popover is visible. Passing this prop puts the popover in
     * controlled mode, where the only way to change visibility is by updating
     * this property. If `disabled={true}`, this prop will be ignored, and the
     * popover will remain closed.
     *
     * @default undefined
     */
    var isOpen: Boolean?
    /**
     * Whether to apply minimal styling to this popover or tooltip. Minimal popovers
     * do not have an arrow pointing to their target and use a subtler animation.
     *
     * @default false
     */
    var minimal: Boolean?
    /**
     * Popper modifier options, passed directly to internal Popper instance. See
     * https://popper.js.org/docs/modifiers/ for complete
     * details.
     */
    var modifiers: dynamic // PopperModifiers
    /**
     * Callback invoked in controlled mode when the popover open state *would*
     * change due to user interaction.
     */
    var onInteraction: ((nextOpenState: Boolean, e: SyntheticEvent<HTMLElement, *>?) -> Unit)?
    /**
     * Whether the popover should open when its target is focused. If `true`,
     * target will render with `tabindex="0"` to make it focusable via keyboard
     * navigation.
     *
     * @default true
     */
    var openOnTargetFocus: Boolean?
    /**
     * The placement (relative to the target) at which the popover should appear.
     * Mutually exclusive with `position` prop.
     *
     * The default value of `"auto"` will choose the best placement when opened
     * and will allow the popover to reposition itself to remain onscreen as the
     * user scrolls around.
     *
     * @see https://popper.js.org/docs/v1/#Popper.placements
     * @default "auto"
     */
    var placement: String? // Popper.Placement
    /**
     * A space-delimited string of class names applied to the popover element.
     */
    var popoverClassName: String?
    /**
     * The position (relative to the target) at which the popover should appear.
     * Mutually exclusive with `placement` prop.
     *
     * The default value of `"auto"` will choose the best position when opened
     * and will allow the popover to reposition itself to remain onscreen as the
     * user scrolls around.
     *
     * @default "auto"
     */
    var position: PopoverPosition?
    /**
     * Space-delimited string of class names applied to the target element.
     */
    var targetClassName: String?
    /**
     * HTML props to spread to target element. Use `targetTagName` to change
     * the type of element rendered. Note that `ref` is not supported.
     */
    var targetProps: HTMLAttributes<HTMLElement>?
    /**
     * HTML tag name for the target element. This must be an HTML element to
     * ensure that it supports the necessary DOM event handlers.
     *
     * By default, a `<span>` tag is used so popovers appear as inline-block
     * elements and can be nested in text. Use `<div>` tag for a block element.
     *
     * @default "span"
     */
    var targetTagName: String? // keyof JSX.IntrinsicElements
    /**
     * Whether the popover should be rendered inside a `Portal` attached to
     * `portalContainer` prop.
     *
     * Rendering content inside a `Portal` allows the popover content to escape
     * the physical bounds of its parent while still being positioned correctly
     * relative to its target. Using a `Portal` is necessary if any ancestor of
     * the target hides overflow or uses very complex positioning.
     *
     * Not using a `Portal` can result in smoother performance when scrolling
     * and allows the popover content to inherit CSS styles from surrounding
     * elements, but it remains subject to the overflow bounds of its ancestors.
     *
     * @default true
     */
    override var usePortal: Boolean?
    /**
     * HTML tag name for the wrapper element, which also receives the
     * `className` prop.
     *
     * @default "span"
     */
    var wrapperTagName: String? // keyof JSX.IntrinsicElements
}

external interface IPopoverProps : PopoverSharedProps {
    /** HTML props for the backdrop element. Can be combined with `backdropClassName`. */
    var backdropProps: PropsWithChildren? /* React.HTMLProps<HTMLDivElement>; */

    /**
     * The content displayed inside the popover. This can instead be provided as
     * the _second_ element in `children` (first is `target`).
     */
    var content: Any? /* String? | JSX.Element? */
    /**
     * Whether the wrapper and target should take up the full width of their container.
     * Note that supplying `true` for this prop will force  `targetTagName="div"` and
     * `wrapperTagName="div"`.
     */
    var fill: Boolean?
    /**
     * The kind of interaction that triggers the display of the popover.
     *
     * @default PopoverInteractionKind.CLICK
     */
    var interactionKind: PopoverInteractionKind?
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
    var shouldReturnFocusOnClose: Boolean?
    /**
     * Ref supplied to the `Classes.POPOVER` element.
     */
    var popoverRef: Ref<HTMLDivElement>?

    /**
     * The target to which the popover content is attached. This can instead be
     * provided as the _first_ element in `children`.
     */
    var target: Any? /* String? | JSX.Element? */
}

external interface IPopoverState : State {
    var transformOrigin: String
    var isOpen: Boolean
    var hasDarkParent: Boolean
}

@Deprecated("Use Popover2", ReplaceWith("Popover2"))
open external class Popover : AbstractPureComponent2<IPopoverProps, IPopoverState> {
    override fun render(): ReactElement<IPopoverProps>
}
