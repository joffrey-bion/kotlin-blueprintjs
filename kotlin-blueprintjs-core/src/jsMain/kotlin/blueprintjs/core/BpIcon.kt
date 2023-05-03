@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*

external object IconSize {
    val STANDARD: Int = definedExternally
    val LARGE: Int = definedExternally
}

external interface IconProps : IntentProps, PropsWithClassName, PropsWithChildren {
    /**
     * Color of icon. This is used as the `fill` attribute on the `<svg>` image
     * so it will override any CSS `color` property, including that set by
     * `intent`. If this prop is omitted, icon color is inherited from
     * surrounding text.
     */
    var color: String?

    /**
     * String for the `title` attribute on the rendered element, which will appear
     * on hover as a native browser tooltip.
     */
    var htmlTitle: String?

    /**
     * Name of a Blueprint UI icon, or an icon element, to render. This prop is
     * required because it determines the content of the component, but it can
     * be explicitly set to falsy values to render nothing.
     *
     * - If `null` or `undefined` or `false`, this component will render nothing.
     * - If given an `IconName` (a string literal union of all icon names), that
     *   icon will be rendered as an `<svg>` with `<path>` tags. Unknown strings
     *   will render a blank icon to occupy space.
     * - If given a `JSX.Element`, that element will be rendered and _all other
     *   props on this component are ignored._ This type is supported to
     *   simplify icon support in other Blueprint components. As a consumer, you
     *   should avoid using `<Icon icon={<Element />}` directly; simply render
     *   `<Element />` instead.
     */
    var icon: dynamic /* IconName | MaybeElement */

    @Deprecated("Use size instead", ReplaceWith("size"))
    var iconSize: Int?

    /**
     * Size of the icon, in pixels. Blueprint contains 16px and 20px SVG icon
     * images, and chooses the appropriate resolution based on this prop.
     *
     * Defaults to [IconSize.STANDARD]
     */
    var size: Int?

    /** CSS style properties. */
    var style: CSSProperties? // TODO

    /**
     * HTML tag to use for the rendered element.
     * @default "span"
     */
    var tagName: String? // keyof JSX.IntrinsicElements

    /**
     * Description string. This string does not appear in normal browsers, but
     * it increases accessibility. For instance, screen readers will use it for
     * aural feedback.
     *
     * If this value is nullish, `false`, or an empty string, the component will assume
     * that the icon is decorative and `aria-hidden="true"` will be applied.
     *
     * @see https://www.w3.org/WAI/tutorials/images/decorative/
     */
    var title: String?
}

/**
 * Icon component.
 *
 * https://blueprintjs.com/docs/#core/components/icon
 */
external class Icon : AbstractPureComponent2<IconProps, State> {

    override fun render(): ReactElement<IconProps>
}
