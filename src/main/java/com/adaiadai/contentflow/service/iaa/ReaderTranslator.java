package com.adaiadai.contentflow.service.iaa;

import com.adaiadai.contentflow.representation.sis.reader.dto.ReadingAtProductOutlineDTO;
import com.adaiadai.contentflow.representation.sis.reader.vo.ReadingAtProductOutlineVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author adai
 */
@Service("iaaReaderTranslator")
public class ReaderTranslator {
    public ReadingAtProductOutlineVO convertToVo(ReadingAtProductOutlineDTO readingAtProductOutlineDto) {
        if (readingAtProductOutlineDto != null) {
            ReadingAtProductOutlineVO readingAtProductOutlineVo = new ReadingAtProductOutlineVO();
            BeanUtils.copyProperties(readingAtProductOutlineDto, readingAtProductOutlineVo);
            return readingAtProductOutlineVo;
        }else {
            return null;
        }
    }
}
