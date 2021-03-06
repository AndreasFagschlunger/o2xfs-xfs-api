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

package at.o2xfs.xfs.idc;

import at.o2xfs.xfs.api.XfsConstant;

public enum TxOutcome implements XfsConstant {

	/*
	 * @since v3.30
	 */
	MULTIPLECARDS(0L),

	/*
	 * @since v3.30
	 */
	APPROVE(1L),

	/*
	 * @since v3.30
	 */
	DECLINE(2L),

	/*
	 * @since v3.30
	 */
	ONLINEREQUEST(3L),

	/*
	 * @since v3.30
	 */
	ONLINEREQUESTCOMPLETIONREQUIRED(4L),

	/*
	 * @since v3.30
	 */
	TRYAGAIN(5L),

	/*
	 * @since v3.30
	 */
	TRYANOTHERINTERFACE(6L),

	/*
	 * @since v3.30
	 */
	ENDAPPLICATION(7L),

	/*
	 * @since v3.30
	 */
	CONFIRMATIONREQUIRED(8L);

	private final long value;

	private TxOutcome(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}