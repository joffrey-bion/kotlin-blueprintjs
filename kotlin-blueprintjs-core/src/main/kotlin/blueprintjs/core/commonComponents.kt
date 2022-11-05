@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.PureComponent
import react.PropsWithChildren
import react.State

/**
 * An abstract component that Blueprint components can extend
 * in order to add some common functionality like runtime props validation.
 */
abstract external class AbstractPureComponent2<P : PropsWithChildren, S : State> : PureComponent<P, S>
