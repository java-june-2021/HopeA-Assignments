package com.HopeA.question.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HopeA.question.models.Answer;
import com.HopeA.question.models.Question;
import com.HopeA.question.models.Tag;
import com.HopeA.question.repositories.AnswerRepository;
import com.HopeA.question.repositories.QuestionRepository;
import com.HopeA.question.repositories.TagRepository;

@Service
public class DiscussionService {
	
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private TagRepository tRepo;
	
	//FIND ALL QUESTIONS
	
	public List<Question> allQuestions() {
		return this.qRepo.findAll();
	}
	
	//FIND ONE QUESTION
	
	public Question findQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	//CREATE QUESTION
	
	public Question createQuestion(Question newQuestion) {
		newQuestion.setTags(this.splitTags(newQuestion.getFrontTags()));
		return this.qRepo.save(newQuestion);
	}
	
	//CREATE ANSWER
	
	public Answer createAnswer(Answer newAnswer) {
		return this.aRepo.save(newAnswer);
	}
	
	//SPLIT TAGS tag1, tag2, tag3
	
	public Tag findTag(String subject) {
		return this.tRepo.findBySubject(subject);
	}
	
	public ArrayList<Tag> splitTags(String tags) {
		ArrayList<Tag> tagsForQ = new ArrayList<Tag>();
		String[] tagsToProcess =tags.split(", ");
		for(String s: tagsToProcess) {
			if(this.tRepo.existsBySubject(s)) {
				Tag tagToAdd = this.findTag(s);
				tagsForQ.add(tagToAdd);
			}else {
				Tag newTag = new Tag();
				newTag.setSubject(s);
				this.tRepo.save(newTag);
				tagsForQ.add(this.findTag(s));
			}
		}
		return tagsForQ;
		
	}

}
