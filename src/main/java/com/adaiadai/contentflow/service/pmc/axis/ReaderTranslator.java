package com.adaiadai.contentflow.service.pmc.axis;

import com.adaiadai.contentflow.representation.sis.reader.dto.ReadingAtProductOutlineDTO;
import com.adaiadai.contentflow.representation.sis.reader.vo.ReadingAtProductOutlineVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author adai
 */
@Service("pmcReaderTranslator")
public class ReaderTranslator {

    public ReadingAtProductOutlineVO convertToReaderVo(ReadingAtProductOutlineDTO readingAtProductOutlineDto) {
        if (readingAtProductOutlineDto != null) {
            ReadingAtProductOutlineVO readingAtProductOutlineVo = new ReadingAtProductOutlineVO();
            BeanUtils.copyProperties(readingAtProductOutlineDto, readingAtProductOutlineVo);
            return readingAtProductOutlineVo;
        } else {
            return null;
        }
    }
}
