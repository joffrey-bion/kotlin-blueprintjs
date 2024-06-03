package blueprintjs.icons

import react.*
import react.dom.*
import react.dom.aria.*
import react.dom.html.*
import web.dom.*
import web.svg.SVGElement

/**
 * Default set of DOM attributes which are assignable as props to the root element rendered by an
 * SVG icon component. This limited set of attributes is assignable to any `<Icon>` component regardless
 * of its `tagName` prop (it works for both HTML and SVG elements).
 */
external interface DefaultSVGIconAttributes : AriaAttributes, DOMAttributes<Element>, HTMLAttributes<Element>

/**
 * DOM attributes which are assignable as props to the root element rendered by an SVG icon component.
 * Specify a type parameter to narrow this type and allow more attributes to be passed to the root element.
 *
 * https://blueprintjs.com/docs/#core/components/icon.dom-attributes
 *
 * When `tagName` is specified, either:
 *  - as a custom HTML element tag name,
 *  - as `null` to signfiy that there should be no wrapper around the `<svg>` element,
 *  - or its default value of "span" is used,
 * then it may be useful to narrow this type to pass along additional attributes which not supported by
 * the more general `DefaultSVGIconAttributes` interface. You can do this by specifying a generic type param
 * on `<Icon>` components, for example:
 *
 * ```
 * <Icon<HTMLSpanElement> icon="drag-handle-horizontal" draggable="false" />
 * ```
 */
// TODO can't really express this in Kotlin, so we fallback to DefaultSVGIconAttributes for now
//external interface SVGIconAttributes<T : Element> :
//        (T : SVGElement
//            ? Omit<React.SVGAttributes<T>, OmittedDOMAttributes>
//            : (T : HTMLElement
//               ? Omit<React.HTMLAttributes<T>, OmittedDOMAttributes>
//               : DefaultSVGIconAttributes
//            )
//        )

external interface SVGIconOwnProps : PropsWithClassName {

    // 'className' included via PropsWithClassName to avoid conflicts with other interfaces

    /** This component does not support child nodes. */
    // Can't really use Nothing to mimic 'never' here, because it's a var and conflicts with other interfaces
    // var children: Nothing?

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
     * Size of the icon, in pixels. Blueprint contains 16px and 20px SVG icon
     * images, and chooses the appropriate resolution based on this prop.
     *
     * @default 16
     */
    var size: Int?

    /** CSS style properties. */
    var style: CSSProperties?

    /**
     * HTML tag to use for the rendered element. Commonly "span" or "div".
     * If `null`, no wrapper will be rendered, just the `<svg>` element.
     *
     * @default "span"
     */
    var tagName: String? // keyof React.JSX.IntrinsicElements | null

    /**
     * Description string. This string does not appear in normal browsers, but
     * it increases accessibility. For instance, screen readers will use it for
     * aural feedback.
     *
     * If this value is nullish, `false`, or an empty string, the component will assume
     * that the icon is decorative and `aria-hidden="true"` will be applied (can be overridden
     * by manually passing `aria-hidden` prop).
     *
     * @see https://www.w3.org/WAI/tutorials/images/decorative/
     */
    var title: String? // string | false | null

    /** Props to apply to the `SVG` element */
    var svgProps: HTMLAttributes<SVGElement>?
}

/**
 * Interface for generated icon components which have their name and icon paths statically defined
 * inside their JS implementation.
 *
 * https://blueprintjs.com/docs/#core/components/icon.static-components
 */
// TODO can't really express SVGIconAttributes in Kotlin, so we can't use SVGIconAttributes<T> here.
//   This means we have to use PropsWithRef<Element> instead of PropsWithRef<T>.
external interface SVGIconProps<T : Element> : PropsWithRef<Element>, DefaultSVGIconAttributes, SVGIconOwnProps

/**
 * The default SVG icon props interface, equivalent to `SVGIconProps` with its default type parameter.
 * This is primarly exported for documentation purposes; users should reference `SVGIconProps<T>` instead.
 */
external interface DefaultSVGIconProps : PropsWithRef<Element>, DefaultSVGIconAttributes, SVGIconOwnProps
