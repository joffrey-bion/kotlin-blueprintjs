@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import blueprintjs.icons.*
import react.*
import react.dom.html.*
import web.dom.*
import web.svg.*

external object IconSize {
    val STANDARD: Int = definedExternally
    val LARGE: Int = definedExternally
}

external interface IconOwnProps {
    /**
     * Whether the component should automatically load icon contents using an async import.
     *
     * @default true
     */
    var autoLoad: Boolean?

    /**
     * Name of a Blueprint UI icon, or an icon element, to render. This prop is
     * required because it determines the content of the component, but it can
     * be explicitly set to falsy values to render nothing.
     *
     * - If `null` or `undefined` or `false`, this component will render nothing.
     * - If given an `IconName` (a string literal union of all icon names), that
     *   icon will be rendered as an `<svg>` with `<path>` tags. Unknown strings
     *   will render a blank icon to occupy space.
     * - If given a `React.JSX.Element`, that element will be rendered and _all other
     *   props on this component are ignored._ This type is supported to
     *   simplify icon support in other Blueprint components. As a consumer, you
     *   should avoid using `<Icon icon={<Element />}` directly; simply render
     *   `<Element />` instead.
     */
    var icon: dynamic /* IconName | MaybeElement */

    /**
     * Alias for `size` prop. Kept around for backwards-compatibility with Blueprint v4.x,
     * will be removed in v6.0.
     *
     * @deprecated use `size` prop instead
     */
    @Deprecated("Use size instead", ReplaceWith("size"))
    var iconSize: Int?

    /** Props to apply to the `SVG` element */
    var svgProps: HTMLAttributes<SVGElement>?;
}

/**
 * Generic interface for the `<Icon>` component which may be parameterized by its root element type.
 *
 * https://blueprintjs.com/docs/#core/components/icon.dom-attributes
 */
external interface IconProps<T : Element> : IntentProps, PropsWithClassName, SVGIconProps<T>, IconOwnProps

/**
 * The default `<Icon>` props interface, equivalent to `IconProps` with its default type parameter.
 * This is primarly exported for documentation purposes; users should reference `IconProps<T>` instead.
 */
external interface DefaultIconProps : IntentProps, PropsWithClassName, DefaultSVGIconProps, IconOwnProps

/**
 * Generic icon component type. This is essentially a type hack required to make forwardRef work with generic
 * components. Note that this slows down TypeScript compilation, but it better than the alternative of globally
 * augmenting "@types/react".
 *
 * @see https://stackoverflow.com/a/73795494/7406866
 */
external interface IconComponent : FC<IconProps<Element>>

/**
 * Icon component.
 *
 * https://blueprintjs.com/docs/#core/components/icon
 */
external val Icon : IconComponent
