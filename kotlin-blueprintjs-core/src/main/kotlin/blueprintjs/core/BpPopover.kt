@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event
import react.RProps
import react.RState
import react.ReactElement

external enum class PopoverInteractionKind {
    CLICK,
    CLICK_TARGET_ONLY,
    HOVER,
    HOVER_TARGET_ONLY
}

external enum class PopoverPosition {
    AUTO,
    AUTO_END,
    AUTO_START,
    BOTTOM,
    BOTTOM_LEFT,
    BOTTOM_RIGHT,
    LEFT,
    LEFT_BOTTOM,
    LEFT_TOP,
    RIGHT,
    RIGHT_BOTTOM,
    RIGHT_TOP,
    TOP,
    TOP_LEFT,
    TOP_RIGHT
}

external interface IPopoverSharedProps : IOverlayableProps, IProps {
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
    var hoverCloseDelay: Number?
    /**
     * The amount of time in milliseconds the popover should wait before opening
     * after the user hovers over the trigger. The timer is canceled if the user
     * mouses away from the target before it expires.
     *
     * @default 150
     */
    var hoverOpenDelay: Number?
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
    var onInteraction: ((nextOpenState: Boolean, e: Event?) -> Unit)?
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
    var targetProps: RProps? // React.HTMLAttributes<HTMLElement>
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

external interface IPopoverProps : IPopoverSharedProps {
    /** HTML props for the backdrop element. Can be combined with `backdropClassName`. */
    var backdropProps: RProps? /* React.HTMLProps<HTMLDivElement>; */

    /**
     * The content displayed inside the popover. This can instead be provided as
     * the _second_ element in `children` (first is `target`).
     */
    var content: dynamic /* String? | JSX.Element? */
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
     * Ref supplied to the `Classes.POPOVER` element.
     */
    var popoverRef: ((ref: HTMLDivElement?) -> Unit)?

    /**
     * The target to which the popover content is attached. This can instead be
     * provided as the _first_ element in `children`.
     */
    var target: dynamic /* String? | JSX.Element? */
}

external interface IPopoverState : RState {
    var transformOrigin: String
    var isOpen: Boolean
    var hasDarkParent: Boolean
}

@Deprecated("Use Popover2", ReplaceWith("Popover2"))
open external class Popover : AbstractPureComponent2<IPopoverProps, IPopoverState> {
    override fun render(): ReactElement
}
