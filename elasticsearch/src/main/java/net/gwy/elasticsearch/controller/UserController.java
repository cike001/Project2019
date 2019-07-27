package net.gwy.elasticsearch.controller;

import net.gwy.elasticsearch.entity.User;
import net.gwy.elasticsearch.repository.UserRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author guoweiyang
 * @date 2019-07-21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/saveUser")
    public ResponseEntity saveUser(@RequestBody User user){

        User u = userRepository.save(user);
        System.out.println("u:"+u.toString());

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        System.out.println("id:"+id);
        Optional<User> optionalUser = userRepository.findById(id);

        User index = optionalUser.get();

        System.out.println("user:"+index.toString());
        return new ResponseEntity<>(index,HttpStatus.OK);
    }

    @RequestMapping("/findAll")
    public ResponseEntity<List<User>> findAllUser(){
        List<User> list = new ArrayList<>();
        Iterable<User> all = userRepository.findAll();
        all.forEach(x -> list.add(x));

        return new ResponseEntity<>(list,HttpStatus.OK);

    }

    @RequestMapping("/delUser/{id}")
    public ResponseEntity<Boolean> delUser(@PathVariable String id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(true,HttpStatus.OK);

    }

    @RequestMapping("/findUserByPage")
    public ResponseEntity<Page<User>> findUserByPage(@RequestParam Integer pageNo,@RequestParam String searchContent){

        SearchQuery query =getPageSearchQuery(pageNo,searchContent);

        Page<User> users = userRepository.search(query);

        return new ResponseEntity<>(users,HttpStatus.OK);

    }

    private SearchQuery getPageSearchQuery(Integer pageNo,String searchContent){

        QueryBuilder queryBuilder =
                QueryBuilders.matchPhraseQuery("name",searchContent);

        Pageable pageable = PageRequest.of(pageNo,5);

        NativeSearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        searchQuery.setPageable(pageable);

        return searchQuery;
    }


}
