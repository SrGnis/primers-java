/*
    This file is part of Primer3 porting to java (https://github.com/primer3-org/primer3)


	Copyright (c) 1996,1997,1998,1999,2000,2001,2004,2006,2007,2008
	Whitehead Institute for Biomedical Research, Steve Rozen
	(http://purl.com/STEVEROZEN/), Andreas Untergasser and Helen Skaletsky
	All rights reserved to Primer3 authors.

    Primer3 and the libprimer3 library are free software;
    you can redistribute them and/or modify them under the terms
    of the GNU General Public License as published by the Free
    Software Foundation; either version 2 of the License, or (at
    your option) any later version.

    This software is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this software (file gpl-2.0.txt in the source
    distribution); if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
OWNERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.primer3.oligotm;

/**
 * Melting Temperature Method 
 * For olgigotm() and seqtm()
 * Both functions return the melting temperature of the given oligo
 * calculated as specified by user, but oligotm _should_ only be used on
 * DNA sequences of length <= MAX_PRIMER_LENGTH (which is defined
 * elsewhere).  seqtm uses oligotm for sequences of length <=
 * MAX_PRIMER_LENGTH, and a different, G+C% based formula for longer
 * sequences.  For oligotm(), no error is generated on sequences
 * longer than MAX_PRIMER_LENGTH, but the formula becomes less
 * accurate as the sequence grows longer.  Caveat emptor.
 * 
 * We use the folowing typedefs:
 * If tm_method==santalucia_auto, then the table of
 * nearest-neighbor thermodynamic parameters and method for Tm
 * calculation in the paper [SantaLucia JR (1998) "A unified view of
 * polymer, dumbbell and oligonucleotide DNA nearest-neighbor
 * thermodynamics", Proc Natl Acad Sci 95:1460-65
 * http://dx.doi.org/10.1073/pnas.95.4.1460] is used.
 * THIS IS THE RECOMMENDED VALUE*.
 * If tm_method==breslauer_auto, then method for Tm
 * calculations in the paper [Rychlik W, Spencer WJ and Rhoads RE
 * (1990) "Optimization of the annealing temperature for DNA
 * amplification in vitro", Nucleic Acids Res 18:6409-12
 * http://www.pubmedcentral.nih.gov/articlerender.fcgi?tool=pubmed&pubmedid=2243783].
 * and the thermodynamic parameters in the paper [Breslauer KJ, Frank
 * R, Blöcker H and Marky LA (1986) "Predicting DNA duplex stability
 * from the base sequence" Proc Natl Acad Sci 83:4746-50
 * http://dx.doi.org/10.1073/pnas.83.11.3746], are is used.  This is
 * the method and the table that primer3 used up to and including
 * version 1.0.1
 */
public enum MeltingTemperatureMethod {
	breslauer_auto(0,"Rychlik W (1990) && Breslauer KJ (1986)"),
	santalucia_auto (1,"SantaLucia JR (1998)");

	private int id ;
	private String name;
	MeltingTemperatureMethod(int id, String name ){
		this.id = id;
		this.name = name;
	}
	public int getValue() { return id; }

	
    public String getName()
    {
    	return name;
    }
    
    
    public String toString()
    {
    	return name;
    }


}
