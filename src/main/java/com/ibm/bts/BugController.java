package com.ibm.bts;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.bts.entity.Bug;
import com.ibm.bts.service.BugService;

@RestController
public class BugController {
	@Autowired
	BugService bugService;
	// DRY
	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("something went wrong, please try again");
		}
	}
	
    @PostMapping("/bug")
	String createBug(@RequestBody @Valid Bug bug, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(bug);
		return bugService.createBug(bug);
	}
    /**
     * method to search for an bug
     * @param bugId
     * @return zero or matching bug
     */
	@GetMapping("/bug/{id}")
	Optional<Bug> getBug(@PathVariable("id") String bugId) {
		return bugService.getBug(bugId);
	}

	@GetMapping("/bug")
	List<Bug> getBugs() {
		return bugService.getBugs();
	}

	@PutMapping("/bug/{id}")
	void updateBug(@RequestBody @Valid Bug bug, @PathVariable("id") String bugId, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(bugId);
		bug.setId(bugId);
		bugService.updateBug(bug);
	}

	@DeleteMapping("/bug/{id}")
	void deleteBug(@PathVariable("id") String bugId) {
		System.out.println(bugId);
		bugService.deleteBug(bugId);
	}
}
