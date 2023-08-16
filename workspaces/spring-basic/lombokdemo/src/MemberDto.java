import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// DTO 만들기
// 1. 필드 선언
// 2. Getter, Setter
// 3. 생성자 (선택적)
// 4. 기타 다른 메서드 (선택적)

@Data // 모든 필드에 대해 getter, setter 자동 생성
public class MemberDto {

	// @Setter @Getter
	private String memberId;
	private String passwd;
	private String email;
	private Date regDate;
	private String userType;
	private boolean deleted;
	
	
	
}
