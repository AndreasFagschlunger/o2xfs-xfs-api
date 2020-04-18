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

package at.o2xfs.xfs.api;

public enum XfsMessage implements XfsConstant {

	OPEN_COMPLETE(1L),
	CLOSE_COMPLETE(2L),
	LOCK_COMPLETE(3L),
	UNLOCK_COMPLETE(4L),
	REGISTER_COMPLETE(5L),
	DEREGISTER_COMPLETE(6L),
	GETINFO_COMPLETE(7L),
	EXECUTE_COMPLETE(8L),

	EXECUTE_EVENT(20L),
	SERVICE_EVENT(21L),
	USER_EVENT(22L),
	SYSTEM_EVENT(23L),

	TIMER_EVENT(100L);

	private final static long WM_USER = 0x0400L;

	private final long value;

	private XfsMessage(final long value) {
		this.value = WM_USER + value;
	}

	public boolean isOperationComplete() {
		switch (this) {
		case OPEN_COMPLETE:
		case CLOSE_COMPLETE:
		case LOCK_COMPLETE:
		case UNLOCK_COMPLETE:
		case REGISTER_COMPLETE:
		case DEREGISTER_COMPLETE:
		case GETINFO_COMPLETE:
		case EXECUTE_COMPLETE:
			return true;
		default:
			return false;
		}
	}

	public boolean isIntermediateEvent() {
		switch (this) {
		case EXECUTE_EVENT:
			return true;
		default:
			return false;
		}
	}

	@Override
	public long getValue() {
		return value;
	}
}