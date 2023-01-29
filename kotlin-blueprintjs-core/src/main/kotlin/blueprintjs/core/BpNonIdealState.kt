@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*

external object NonIdealStateIconSize {
    val STANDARD: Int = definedExternally
    val SMALL: Int = definedExternally
    val EXTRA_SMALL: Int = definedExternally
}

external interface NonIdealStateProps : PropsWithClassName, PropsWithChildren {
    /** An action to resolve the non-ideal state which appears after `description`. */
    var action: ReactElement<*>?

    /**
     * A longer description of the non-ideal state.
     * A string or number value will be wrapped in a `<div>` to preserve margins.
     */
    var description: ReactElement<*>?

    /** The name of a Blueprint icon or a JSX Element (such as `<Spinner/>`) to render above the title. */
    var icon: dynamic // IconName? | MaybeElement?

    /**
     * How large the icon visual should be.
     *
     * Default [NonIdealStateIconSize.STANDARD]
     */
    var iconSize: Int?

    /**
     * Component layout, either vertical or horizontal.
     *
     * @default "vertical"
     */
    var layout: String? // "vertical" | "horizontal" | null

    /** The title of the non-ideal state. */
    var title: ReactNode?
}

/**
 * Non-ideal state component.
 *
 * https://blueprintjs.com/docs/#core/components/non-ideal-state
 */
external class NonIdealState : AbstractPureComponent2<NonIdealStateProps, State> {
    override fun render(): ReactElement<NonIdealStateProps>
}
