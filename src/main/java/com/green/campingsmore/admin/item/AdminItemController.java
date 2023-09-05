package com.green.campingsmore.admin.item;

import com.green.campingsmore.admin.item.model.*;
import com.green.campingsmore.entity.ItemDetailPicEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "관리자 아이템")
@RequestMapping("/api/admin/item")
@RequiredArgsConstructor
public class AdminItemController {
    private final AdminItemService service;


    // 아이템 ------------------------------------------------------------------------------------------------------

    @PostMapping("/category")
    @Operation(summary = "아이템 카테고리 추가")
    public ResponseEntity<ItemCategoryVo> postItemCategory(@RequestBody ItemCategoryInsDto dto) {
        ItemCategoryVo vo = service.saveCategory(dto);
        return ResponseEntity.ok(vo);
    }


    @PostMapping
    @Operation(summary = "아이템 추가"
            , description = "" +
            "\"iitemCategory\": [-] 아이템 카테고리 PK,<br>" +
            "\"name\": [-] 아이템 제목,<br>" +
            "\"pic\": [-]  아이템 썸네일 pic url,<br>" +
            "\"price\": [-] 아이템 가격,<br>" +
            "\"stock\": [-] 아이템 재고,<br>" +
            "\"status\": [-] 아이템 상태(삭제(0) / 판매중(1): 유저에게 노출 / 판매중지(2): 유저에게 노출되지않음),<br>" +
            "\"picUrl\": [-] 사진 이미지 url<br>")
    public ResponseEntity<ItemVo> postItem(@RequestBody ItemInsDto dto) {
        ItemVo vo = service.saveItem(dto);
        return ResponseEntity.ok(vo);
    }

    @PutMapping
    @Operation(summary = "아이템 수정"
            , description = "" +
            "\"iitem\": [-] 아이템 PK,<br>" +
            "\"iitemCategory\": [-] 아이템 카테고리 PK,<br>" +
            "\"name\": [-] 아이템 제목,<br>" +
            "\"pic\": [-]  아이템 썸네일 pic url,<br>" +
            "\"price\": [-] 아이템 가격,<br>" +
            "\"stock\": [-] 아이템 재고,<br>" +
            "\"status\": [-] 아이템 상태(삭제(0) / 판매중(1): 유저에게 노출 / 판매중지(2): 유저에게 노출되지않음),<br>" +
            "\"picUrl\": [-] 사진 이미지 url<br>")
    public ResponseEntity<ItemVo> putItem(@RequestBody ItemUpdDto dto) {
        ItemVo vo = service.updItem(dto);
        return ResponseEntity.ok(vo);
    }

    @PostMapping("/detail-pic")
    @Operation(summary = "아이템 상세이미지 업로드"
            , description = "" +
            "\"iitem\": [-] 아이템 PK,<br>" +
            "\"picUrl\": [-] 사진 이미지 url<br>")
    public ResponseEntity<ItemDetailPicVo> postDetailPic(@RequestBody ItemInsDetailPicDto dto) {
        ItemDetailPicVo vo = service.saveItemDetailPic(dto);
        return ResponseEntity.ok(vo);
    }

    @DeleteMapping("/{iitem}")
    @Operation(summary = "아이템 삭제 - 관리자 페이지"
            , description = "" +
            "\"iitem\": [-] 아이템 PK<br>")
    public void delItem(@PathVariable Long iitem) {
        service.delItem(iitem);
    }

    // 추천 아이템 ------------------------------------------------------------------------------------------------------

    @PostMapping("/bestitem")
    @Operation(summary = "추천 아이템 추가"
            , description = "" +
            "\"iitem\": [-] 아이템 PK,<br>" +
            "\"monthLike\": [yyyy-MM-dd] 추천 아이템 노출 할 년월")
    public ResponseEntity<ItemBestVo> postBestItem(@RequestBody ItemInsBestDto dto) {
        ItemBestVo vo = service.saveBestItem(dto);
        return ResponseEntity.ok(vo);
    }


}