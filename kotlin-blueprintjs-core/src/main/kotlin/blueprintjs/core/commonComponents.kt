@file:JsModule("@blueprintjs/core")

package blueprintjs.core

import react.PureComponent
import react.RProps
import react.RState

/**
 * An abstract component that Blueprint components can extend
 * in order to add some common functionality like runtime props validation.
 *
 * @deprecated componentWillReceiveProps is deprecated in React 16.9; use AbstractPureComponent2 instead
 */
@Deprecated("componentWillReceiveProps is deprecated in React 16.9; use AbstractPureComponent2 instead", ReplaceWith("AbstractPureComponent2"))
abstract external class AbstractPureComponent<P : RProps, S : RState> : PureComponent<P, S>

/**
 * An abstract component that Blueprint components can extend
 * in order to add some common functionality like runtime props validation.
 */
abstract external class AbstractPureComponent2<P : RProps, S : RState> : PureComponent<P, S>