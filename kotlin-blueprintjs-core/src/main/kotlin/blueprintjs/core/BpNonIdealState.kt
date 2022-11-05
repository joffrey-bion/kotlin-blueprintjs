@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.State
import react.ReactElement

external interface INonIdealStateProps : IProps {
    /** An action to resolve the non-ideal state which appears after `description`. */
    var action: ReactElement<*>?

    /**
     * A longer description of the non-ideal state.
     * A string or number value will be wrapped in a `<div>` to preserve margins.
     */
    var description: ReactElement<*>?

    /** The name of a Blueprint icon or a JSX Element (such as `<Spinner/>`) to render above the title. */
    var icon: dynamic // IconName? | MaybeElement?

    /** The title of the non-ideal state. */
    var title: ReactElement<*>?
}

external class NonIdealState : AbstractPureComponent2<INonIdealStateProps, State> {
    override fun render(): ReactElement<INonIdealStateProps>
}
