@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.RState
import react.ReactElement

/** This component also supports the full range of HTML `<div>` props. */
external interface ICalloutProps : IIntentProps, IProps, HTMLDivProps {
    /**
     * Name of a Blueprint UI icon (or an icon element) to render on the left side.
     *
     * If this prop is omitted or `undefined`, the `intent` prop will determine a default icon.
     * If this prop is explicitly `null`, no icon will be displayed (regardless of `intent`).
     */
    var icon: dynamic /* IconName | MaybeElement */
    /**
     * Visual intent color to apply to background, title, and icon.
     *
     * Defining this prop also applies a default icon, if the `icon` prop is omitted.
     */
    override var intent: Intent?
    /**
     * String content of optional title element.
     *
     * Due to a conflict with the HTML prop types, to provide JSX content simply
     * pass `<H4>JSX title content</H4>` as first `children` element instead of
     * using this prop (note uppercase tag name to use the Blueprint Heading
     * component).
     */
    var title: String?
}

open external class Callout : AbstractPureComponent2<ICalloutProps, RState> {
    override fun render(): ReactElement
}
