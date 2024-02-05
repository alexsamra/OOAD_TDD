/*
 * ******************************************************************************
 *  This files was developed for CS4233: Object-Oriented Analysis & Design.
 *  The course was taken at Worcester Polytechnic Institute.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  * Copyright ©2016-2024 Gary F. Pollice
 *  *******************************************************************************
 *
 */

package knibble;

/**
 * This record represents the response that the KnibbleGame
 * will return from the <code>guess()</code> method.
 * YOU MAY NOT MODIFY THIS FILE
 */
public record KnibbleResponse(ResponseCode code, String message) {
};
