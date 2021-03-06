/*
 * Copyright (c) 2017, Andreas Fagschlunger. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package at.o2xfs.xfs.cim;

import at.o2xfs.xfs.api.XfsConstant;

public enum Position implements XfsConstant {

	/*
	 * @since v3.00
	 */
	NULL(0x0000),

	/*
	 * @since v3.00
	 */
	INLEFT(0x0001),

	/*
	 * @since v3.00
	 */
	INRIGHT(0x0002),

	/*
	 * @since v3.00
	 */
	INCENTER(0x0004),

	/*
	 * @since v3.00
	 */
	INTOP(0x0008),

	/*
	 * @since v3.00
	 */
	INBOTTOM(0x0010),

	/*
	 * @since v3.00
	 */
	INFRONT(0x0020),

	/*
	 * @since v3.00
	 */
	INREAR(0x0040),

	/*
	 * @since v3.00
	 */
	OUTLEFT(0x0080),

	/*
	 * @since v3.00
	 */
	OUTRIGHT(0x0100),

	/*
	 * @since v3.00
	 */
	OUTCENTER(0x0200),

	/*
	 * @since v3.00
	 */
	OUTTOP(0x0400),

	/*
	 * @since v3.00
	 */
	OUTBOTTOM(0x0800),

	/*
	 * @since v3.00
	 */
	OUTFRONT(0x1000),

	/*
	 * @since v3.00
	 */
	OUTREAR(0x2000);

	private final long value;

	private Position(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}