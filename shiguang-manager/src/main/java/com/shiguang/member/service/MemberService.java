package com.shiguang.member.service;

import com.shiguang.common.utils.R;
import com.shiguang.member.domain.MemberDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface MemberService {
    MemberDO get(Long id);

    List<MemberDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(MemberDO member);

    int update(MemberDO member);

    int remove(Long id);

    int batchRemove(Long[] ids,Long status);
    int updateStatus(MemberDO memberDO);

    R importMember(String departNumber, String checkType, MultipartFile file);
}
