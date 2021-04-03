package blueprintjs.core

import org.w3c.dom.HTMLAnchorElement
import react.RProps
import react.ReactElement

/**
 * Represents the name of any icon in @blueprintjs/icons
 */
typealias IconName = String

/**
 * Alias for a `JSX.Element` or a value that renders nothing.
 *
 * In React, `boolean`, `null`, and `undefined` do not produce any output.
 */
typealias MaybeElement = ReactElement?

typealias IRef<T> = Any /* IRefObject<T> | IRefCallback<T> */

typealias IRefCallback<T> = (T?) -> Any

typealias IAnchorButtonProps = IButtonProps<HTMLAnchorElement>