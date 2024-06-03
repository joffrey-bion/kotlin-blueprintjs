@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.*

/**
 * An abstract component that Blueprint components can extend
 * in order to add some common functionality like runtime props validation.
 */
abstract external class AbstractPureComponent<P : PropsWithChildren, S : State> : PureComponent<P, S>
