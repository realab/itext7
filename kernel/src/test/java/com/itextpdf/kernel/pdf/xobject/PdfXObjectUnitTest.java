/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2021 iText Group NV
    Authors: iText Software.

    This program is offered under a commercial and under the AGPL license.
    For commercial licensing, contact us at https://itextpdf.com/sales.  For AGPL licensing, see below.

    AGPL licensing:
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.itextpdf.kernel.pdf.xobject;

import com.itextpdf.kernel.exceptions.KernelExceptionMessageConstant;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfStream;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.type.UnitTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

@Category(UnitTest.class)
public class PdfXObjectUnitTest extends ExtendedITextTest {
    @Rule
    public ExpectedException junitExpectedException = ExpectedException.none();

    @Test
    public void noSubTypeProvidedTest() {
        junitExpectedException.expect(UnsupportedOperationException.class);
        junitExpectedException.expectMessage(KernelExceptionMessageConstant.UNSUPPORTED_XOBJECT_TYPE);

        PdfStream pdfStream = new PdfStream();
        PdfXObject pdfXObject = PdfXObject.makeXObject(pdfStream);
    }

    @Test
    public void unsupportedSubTypeIsSet() {
        junitExpectedException.expect(UnsupportedOperationException.class);
        junitExpectedException.expectMessage(KernelExceptionMessageConstant.UNSUPPORTED_XOBJECT_TYPE);

        PdfStream pdfStream = new PdfStream();
        pdfStream.put(PdfName.Subtype, new PdfName("Unsupported SubType"));
        PdfXObject pdfXObject = PdfXObject.makeXObject(pdfStream);
    }
}
