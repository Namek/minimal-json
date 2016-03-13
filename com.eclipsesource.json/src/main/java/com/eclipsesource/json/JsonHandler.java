/*******************************************************************************
 * Copyright (c) 2016 EclipseSource.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.eclipsesource.json;

import com.eclipsesource.json.JsonParser.Location;


/**
 * A handler for parser events.
 *
 * @param <A>
 *          The type of handlers used for JSON arrays
 * @param <O>
 *          The type of handlers used for JSON objects
 *
 * @see JsonParser
 */
public abstract class JsonHandler<A, O> {

  JsonParser parser;

  /**
   * Returns the current parser location.
   *
   * @return the current parser location
   */
  protected Location getLocation() {
    return parser.getLocation();
  }

  /**
   * Indicates the beginning of a JSON <code>null</code> literal in the input. This method will be
   * called when reading the first character of the literal.
   */
  public void startNull() {
  }

  /**
   * Indicates the end of a JSON <code>null</code> literal in the input. This method will be
   * called when reading the last character of the literal.
   */
  public void endNull() {
  }

  /**
   * Indicates the beginning of a JSON <code>true</code> literal in the input. This method will be
   * called when reading the first character of the literal.
   */
  public void startTrue() {
  }

  /**
   * Indicates the end of a JSON <code>true</code> literal in the input. This method will be
   * called when reading the last character of the literal.
   */
  public void endTrue() {
  }

  /**
   * Indicates the beginning of a JSON <code>false</code> literal in the input. This method will
   * be called when reading the first character of the literal.
   */
  public void startFalse() {
  }

  /**
   * Indicates the end of a JSON <code>false</code> literal in the input. This method will be
   * called when reading the last character of the literal.
   */
  public void endFalse() {
  }

  /**
   * Indicates the beginning of a JSON string in the input. This method will be called when
   * reading the opening double quote character (<code>'"'</code>).
   */
  public void startString() {
  }

  /**
   * Indicates the end of a JSON string in the input. This method will be called when reading the
   * closing double quote character (<code>'"'</code>).
   *
   * @param string
   *          the parsed string
   */
  public void endString(String string) {
  }

  /**
   * Indicates the beginning of a JSON number in the input. This method will be called when
   * reading the first character of the number.
   */
  public void startNumber() {
  }

  /**
   * Indicates the end of a JSON number in the input. This method will be called when reading the
   * last character of the number.
   *
   * @param string
   *          the parsed number string
   */
  public void endNumber(String string) {
  }

  /**
   * Indicates the beginning of a JSON array in the input. This method will be called when reading
   * the opening square bracket character (<code>'['</code>).
   * <p>
   * This method may return an object to handle subsequent parser events for this array. This array
   * handler will then be provided in all calls to {@link #startArrayValue(Object)
   * startArrayValue()}, {@link #endArrayValue(Object) endArrayValue()}, and
   * {@link #endArray(Object) endArray()} for this array.
   * </p>
   *
   * @return a handler for this array, or <code>null</code> if not needed
   */
  public A startArray() {
    return null;
  }

  /**
   * Indicates the end of a JSON array in the input. This method will be called when reading the
   * closing square bracket character (<code>']'</code>).
   *
   * @param array
   *          the array handler returned from {@link #startArray()}, or <code>null</code> if not
   *          provided
   */
  public void endArray(A array) {
  }

  /**
   * Indicates the beginning of an array element in the input. This method will be called when
   * reading the first character of the element, just before the call to the <code>start</code>
   * method for the specific element type ({@link #startString()}, {@link #startNumber()}, etc.).
   *
   * @param array
   *          the array handler returned from {@link #startArray()}, or <code>null</code> if not
   *          provided
   */
  public void startArrayValue(A array) {
  }

  /**
   * Indicates the end of a JSON array element in the input. This method will be called when reading
   * the last character of the element value, just after the <code>end</code> method for the
   * specific element type (like {@link #endString(String) endString()}, {@link #endNumber(String)
   * endNumber()}, etc.).
   *
   * @param array
   *          the array handler returned from {@link #startArray()}, or <code>null</code> if not
   *          provided
   */
  public void endArrayValue(A array) {
  }

  /**
   * Indicates the beginning of a JSON object in the input. This method will be called when reading
   * the opening curly bracket character (<code>'{'</code>).
   * <p>
   * This method may return an object to handle subsequent parser events for this object. This
   * object handler will be provided in all calls to {@link #startObjectName(Object)
   * startObjectName()}, {@link #endObjectName(Object, String) endObjectName()},
   * {@link #startObjectValue(Object, String) startObjectValue()},
   * {@link #endObjectValue(Object, String) endObjectValue()}, and {@link #endObject(Object)
   * endObject()} for this object.
   * </p>
   *
   * @return a handler for this object, or <code>null</code> if not needed
   */
  public O startObject() {
    return null;
  }

  /**
   * Indicates the end of a JSON object in the input. This method will be called when reading the
   * closing curly bracket character (<code>'}'</code>).
   *
   * @param object
   *          the object handler returned from {@link #startObject()}, or null if not provided
   */
  public void endObject(O object) {
  }

  /**
   * Indicates the beginning of the name of an object member in the input. This method will be
   * called when reading the opening quote character ('&quot;') of the member name.
   *
   * @param object
   *          the object handler returned from {@link #startObject()}, or <code>null</code> if not
   *          provided
   */
  public void startObjectName(O object) {
  }

  /**
   * Indicates the end of a JSON object member name in the input. This method will be called when
   * reading the closing quote character (<code>'"'</code>) of the member name.
   *
   * @param object
   *          the object handler returned from {@link #startObject()}, or null if not provided
   * @param name
   *          the parsed member name
   */
  public void endObjectName(O object, String name) {
  }

  /**
   * Indicates the beginning of the name of an object member in the input. This method will be
   * called when reading the opening quote character ('&quot;') of the member name.
   *
   * @param object
   *          the object handler returned from {@link #startObject()}, or <code>null</code> if not
   *          provided
   * @param name
   *          the member name
   */
  public void startObjectValue(O object, String name) {
  }

  /**
   * Indicates the end of a JSON object member value in the input. This method will be called when
   * reading the last character of the member value, just after the <code>end</code> method for the
   * specific member type (like {@link #endString(String) endString()}, {@link #endNumber(String)
   * endNumber()}, etc.).
   *
   * @param object
   *          the object handler returned from {@link #startObject()}, or null if not provided
   * @param name
   *          the parsed member name
   */
  public void endObjectValue(O object, String name) {
  }

}