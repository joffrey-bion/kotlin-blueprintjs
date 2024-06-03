@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*
import react.dom.events.*
import react.dom.html.*
import web.html.*

external interface TagSharedProps : PropsWithClassName, IntentProps {

    /**
     * Whether the tag should appear in an active state.
     *
     * @default false
     */
    var active: Boolean?

    /**
     * Name of a Blueprint UI icon (or an icon element) to render on the left side of the tag,
     * before any content.
     */
    var icon: Any? // IconName? | MaybeElement?

    /**
     * Whether the tag should take up the full width of its container.
     *
     * @default false
     */
    var fill: Boolean?

    /**
     * Whether the tag should visually respond to user interactions. If set
     * to `true`, hovering over the tag will change its color and mouse cursor.
     *
     * Recommended when `onClick` is also defined.
     *
     * @default false
     */
    var interactive: Boolean?

    /**
     * Whether this tag should use large styles.
     *
     * @default false
     */
    var large: Boolean?

    /**
     * Whether this tag should use minimal styles.
     *
     * @default false
     */
    var minimal: Boolean?

    /**
     * Callback invoked when the tag is clicked.
     * Recommended when `interactive` is `true`.
     */
    var onClick: MouseEventHandler<HTMLSpanElement>?

    /**
     * Name of a Blueprint UI icon (or an icon element) to render on the right side of the tag,
     * after the child node(s).
     */
    var rightIcon: Any? // IconName? | MaybeElement?

    /**
     * Whether this tag should have rounded ends.
     * @default false
     */
    var round: Boolean?
}
