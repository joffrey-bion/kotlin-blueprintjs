package blueprintjs.core

import react.ReactElement
import react.dom.html.HTMLAttributes
import react.dom.html.InputHTMLAttributes
import web.html.HTMLDivElement
import web.html.HTMLInputElement

/**
 * Alias for a `JSX.Element` or a value that renders nothing.
 *
 * In React, `boolean`, `null`, and `undefined` do not produce any output.
 */
typealias MaybeElement = ReactElement<*>?

/**
 * Alias for all valid HTML props for `<div>` element.
 * Does not include React's `ref` or `key`.
 */
// export declare type HTMLDivProps = React.HTMLAttributes<HTMLDivElement>
typealias HTMLDivProps = HTMLAttributes<HTMLDivElement>

/**
 * Alias for all valid HTML props for `<input>` element.
 * Does not include React's `ref` or `key`.
 */
// export declare type HTMLInputProps = React.InputHTMLAttributes<HTMLInputElement>
typealias HTMLInputProps = InputHTMLAttributes<HTMLInputElement>
