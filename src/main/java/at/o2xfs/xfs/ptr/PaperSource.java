/*
 * Copyright (c) 2018, Andreas Fagschlunger. All rights reserved.
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

package at.o2xfs.xfs.ptr;

import at.o2xfs.xfs.api.XfsConstant;

public enum PaperSource implements XfsConstant {

	/*
	 * @since v3.00
	 */
	ANY(0x0001),

	/*
	 * @since v3.00
	 */
	UPPER(0x0002),

	/*
	 * @since v3.00
	 */
	LOWER(0x0004),

	/*
	 * @since v3.00
	 */
	EXTERNAL(0x0008),

	/*
	 * @since v3.00
	 */
	AUX(0x0010),

	/*
	 * @since v3.00
	 */
	AUX2(0x0020),

	/*
	 * @since v3.00
	 */
	PARK(0x0040);

	private final long value;

	private PaperSource(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}
