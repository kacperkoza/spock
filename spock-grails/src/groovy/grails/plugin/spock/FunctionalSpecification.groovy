/* Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package grails.plugin.spock

import grails.plugin.spock.functional.WebSession
import spock.lang.Shared

class FunctionalSpecification extends IntegrationSpecification {
  static baseUrl // set by the build infrastructure
  
  @Shared session
  
  def setupSpeck() {
    session = new WebSession(baseUrl)
  }

  def methodMissing(String name, args) {
    session."$name"(*args)
  }
  
  def propertyMissing(String name) {
    session."$name"
  }
  
  def propertyMissing(String name, value) {
    session."$name" = value
  }
}