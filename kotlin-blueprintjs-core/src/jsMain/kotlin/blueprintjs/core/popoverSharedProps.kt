@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.events.*
import react.dom.html.*
import web.html.*

external interface DefaultPopoverTargetHTMLProps : HTMLAttributes<HTMLElement>// HTMLProps<HTMLElement>

/**
 * Props shared between `Popover` and `Tooltip`.
 *
 * @template TProps HTML props interface for target element,
 *                  defaults to props for HTMLElement in IPopoverProps and ITooltipProps
 */
external interface PopoverSharedProps<TProps : DefaultPopoverTargetHTMLProps> : OverlayableProps, PropsWithClassName, PropsWithChildren {
    
    // 'children' is declared via PropsWithChildren

    /**
     * A boundary element supplied to the "flip" and "preventOverflow" modifiers.
     * This is a shorthand for overriding Popper.js modifier options with the `modifiers` prop.
     *
     * https://popper.js.org/docs/v2/utils/detect-overflow/#boundary
     */
    var boundary: dynamic // Popper's Boundary = Element | Array<Element> | 'clippingParents'
    /**
     * When enabled, clicks inside a `Classes.POPOVER_DISMISS` element
     * will only close the current popover and not outer popovers.
     * When disabled, the current popover and any ancestor popovers will be closed.
     *
     * http://blueprintjs.com/docs/#core/components/popover.closing-on-click
     *
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
     * Whether the wrapper and target should take up the full width of their container.
     * Note that supplying `true` for this prop will force  `targetTagName="div"`.
     */
    var fill: Boolean?
    /**
     * The amount of time in milliseconds the popover should remain open after
     * the user hovers off the trigger. The timer is canceled if the user mouses
     * over the target before it expires.
     *
     * @default 300
     */
    var hoverCloseDelay: Int?
    /**
     * The amount of time in milliseconds the popover should wait before opening
     * after the user hovers over the trigger. The timer is canceled if the user
     * mouses away from the target before it expires.
     *
     * @default 150
     */
    var hoverOpenDelay: Int?
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
     * Whether the popover content should be sized to match the width of the target.
     * This is sometimes useful for dropdown menus. This prop is implemented using
     * a Popper.js custom modifier.
     *
     * @default false
     */
    var matchTargetWidth: Boolean?
    /**
     * Whether to apply minimal styling to this popover or tooltip. Minimal popovers
     * do not have an arrow pointing to their target and use a subtler animation.
     *
     * @default false
     */
    var minimal: Boolean?
    /**
     * Overrides for Popper.js built-in modifiers.
     * Each override is is a full modifier object (omitting its name), keyed by its modifier name.
     *
     * For example, the arrow modifier can be disabled by providing `{ arrow: { enabled: false } }`.
     *
     * Some of Popover's default modifiers may get disabled under certain circumstances, but you may
     * choose to re-enable and customize them. For example, "offset" is disabled when `minimal={true}`,
     * but you can re-enable it with `{ offset: { enabled: true } }`.
     *
     * https://popper.js.org/docs/v2/modifiers/
     */
    var modifiers: dynamic // PopperModifierOverrides
    /**
     * Custom modifiers to add to the popper instance.
     *
     * https://popper.js.org/docs/v2/modifiers/#custom-modifiers
     */
    var modifiersCustom: dynamic // readonly PopperCustomModifier[]
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
     * Note that this functionality is only enabled for hover interaction
     * popovers/tooltips.
     *
     * @default true
     */
    var openOnTargetFocus: Boolean?
    /**
     * DOM ref attached to the `Classes.POPOVER` element.
     */
    var popoverRef: Ref<HTMLElement>?
    /**
     * Target renderer which receives props injected by Popover which should be spread onto
     * the rendered element. This function should return a single React node.
     *
     * Mutually exclusive with `children` and `targetTagName` props.
     */
    var renderTarget: ((props: TProps) -> ReactElement<*>)?
    /**
     * A root boundary element supplied to the "flip" and "preventOverflow" modifiers.
     * This is a shorthand for overriding Popper.js modifier options with the `modifiers` prop.
     *
     * https://popper.js.org/docs/v2/utils/detect-overflow/#rootboundary
     */
    var rootBoundary: String? // Popper's RootBoundary = 'viewport' | 'document'
    /**
     * The placement (relative to the target) at which the popover should appear.
     * Mutually exclusive with `position` prop. Prefer using this over `position`,
     * as it more closely aligns with Popper.js semantics.
     *
     * The default value of `"auto"` will choose the best placement when opened
     * and will allow the popover to reposition itself to remain onscreen as the
     * user scrolls around.
     *
     * @default "auto"
     */
    var placement: String? // Popper's Placement = "auto" | "auto-start" | "auto-end" | "top" | "bottom" | "right" | "left" | "top-start" | "top-end" | "bottom-start" | "bottom-end" | "right-start" | "right-end" | "left-start" | "left-end"
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
     * HTML tag name for the target element. This must be an HTML element to
     * ensure that it supports the necessary DOM event handlers.
     *
     * By default, a `<span>` tag is used so popovers appear as inline-block
     * elements and can be nested in text. Use `<div>` tag for a block element.
     *
     * If `fill` is set to `true`, this prop's default value will become `"div"`
     * instead of `"span"`.
     *
     * Note that _not all HTML tags are supported_; you will need to make sure
     * the tag you choose supports the HTML attributes Popover applies to the
     * target element.
     *
     * This prop is mutually exclusive with the `renderTarget` API.
     *
     * @default "span" ("div" if `fill={true}`)
     */
    var targetTagName: String? // keyof React.JSX.IntrinsicElements?
    /**
     * HTML props for the target element. This is useful in some cases where you
     * need to render some simple attributes on the generated target element.
     *
     * For more complex use cases, consider using the `renderTarget` API instead.
     * This prop will be ignored if `renderTarget` is used.
     */
    var targetProps: TProps?
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
}
