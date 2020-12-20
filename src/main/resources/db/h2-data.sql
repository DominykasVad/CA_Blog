INSERT INTO users (email, name, password, surname, username)
VALUES ('foo@bar.com',
        'Admin',
        '{bcrypt}$2y$12$Ngi.pR.qcdFkMKVHlQl0AeKyn68vF9tId6Hk7So478VVr54TMlLfy/q',
        'Admin',
        'Admin');

INSERT INTO role (role_name)
VALUES ('USER'),
       ('ADMIN');

INSERT INTO user_roles (user_id, role_id)
VALUES ('1', '1');

INSERT INTO posts (post_content, post_title, user_id)
VALUES ('<strong>Lorem ipsum</strong> dolor sit amet, consectetur adipiscing elit. Nunc at auctor dolor, a blandit arcu. Suspendisse mauris enim, eleifend non malesuada et, rutrum sed ipsum. Sed tristique risus lorem, malesuada luctus nibh efficitur sed. Praesent et blandit nunc. Vivamus libero metus, finibus viverra pretium ut, convallis ut massa. Proin hendrerit nisl vitae iaculis facilisis. Proin laoreet at arcu nec pretium. Morbi vitae cursus nisl, quis posuere elit. Etiam ligula metus, hendrerit vitae convallis rhoncus, egestas nec tellus. Praesent finibus sapien tellus, sit amet convallis magna dignissim in. Phasellus tempor euismod rhoncus. ',
        'post 1 title', 1),
       ('Sed volutpat sed ante non dignissim. <br> Cras id feugiat dui. Nam et molestie tortor. Vestibulum eget augue volutpat, lacinia felis non, posuere sem. Curabitur eget elit volutpat, egestas risus sit amet, bibendum turpis. Aenean sagittis dolor quis est viverra euismod. Sed ultricies diam ullamcorper elementum rutrum. Aenean volutpat odio elementum nunc elementum pulvinar. Proin nunc mauris, fermentum in luctus vitae, ultricies ut ante. Phasellus at orci et purus consectetur cursus. Praesent congue tincidunt vulputate. Praesent faucibus neque vel pretium ultrices. ',
        'post 2 title', 1),
       ('Nunc et luctus ligula. Curabitur ac quam eros. Nunc feugiat felis eu tempus eleifend. Pellentesque neque ipsum, ultrices vel tincidunt in, vestibulum non ipsum. Sed ac nibh mattis, lobortis enim eu, auctor justo. Donec eget est aliquam, feugiat ex in, malesuada mi. Curabitur maximus odio vitae porta fringilla. Nullam nec pulvinar ante, et volutpat nisl. Pellentesque pellentesque ornare velit aliquam rhoncus. Duis convallis lacus vel nunc iaculis hendrerit. Mauris ante ante, ultricies quis neque vel, pharetra blandit purus. Maecenas vitae turpis sagittis, porta sem id, faucibus ante. Maecenas pulvinar mattis lobortis. Fusce sodales porttitor ex laoreet commodo. Duis non nisi vel sem rhoncus ultrices.',
        'post 3 title', 1),
       ('Mauris euismod neque est, id convallis ex porttitor ac. Phasellus auctor ligula a luctus vulputate. Nunc faucibus molestie nisi, ut pulvinar diam scelerisque vitae. Curabitur varius tortor nec libero congue, nec sollicitudin mauris bibendum. Donec vulputate augue ut leo tempor rutrum. Vivamus eget elit commodo, tristique orci nec, vulputate ipsum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Duis egestas odio arcu, sed congue nisi tristique pellentesque. Phasellus id nisi placerat metus accumsan rutrum et ac neque. Sed nec nisl at risus ultrices auctor et quis magna. Cras lacinia massa at nunc convallis, at pulvinar magna ultrices. Cras facilisis ante sed felis eleifend luctus. In tempor vel orci eget consectetur.',
        'post 4 title', 1),
       ('Aliquam dapibus, erat eu semper malesuada, sapien leo pretium risus, nec malesuada quam ipsum ac tellus. Donec ac ipsum ex. Nulla sit amet dictum purus. Aliquam leo diam, porta at nulla sit amet, dignissim dictum tortor. Integer molestie sapien quis arcu sollicitudin pharetra. Vestibulum in imperdiet ipsum. Integer porttitor arcu mi, vitae rutrum risus sodales vitae. Pellentesque non sem egestas, sollicitudin lorem eget, commodo ex. Sed tempor risus libero, sit amet porttitor lacus consectetur a. Nullam diam dui, laoreet et neque nec, iaculis hendrerit sapien. Praesent vulputate pulvinar nunc vel facilisis. Aliquam consequat laoreet dolor in facilisis. Donec ornare lobortis tempor. Nulla facilisi.',
        'post 5 title', 1),
       ('In egestas cursus semper. Curabitur rutrum mauris vitae magna scelerisque viverra. Fusce sed mi et metus pharetra sodales sed nec tortor. Aenean pretium, orci vitae dictum cursus, ipsum odio pulvinar ex, id dignissim lectus nisi ut ligula. Integer lobortis mauris turpis, eget lacinia dui maximus tristique. Phasellus quis risus quis est consectetur semper eu at urna. Donec scelerisque semper neque, a euismod nibh fringilla a. Maecenas tortor nibh, mollis et malesuada id, luctus at eros. Nullam ullamcorper lacus nec ligula aliquet, et ultricies velit sagittis. Nunc et elit tellus. In hac habitasse platea dictumst. ',
        'post 6 title', 1),
       ('Donec arcu diam, blandit vel facilisis sed, feugiat quis elit. Mauris nulla magna, bibendum vitae condimentum sit amet, condimentum in urna. Nullam pulvinar lorem nisi, non accumsan lorem fermentum at. Vivamus quis sollicitudin metus, a pretium ligula. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla in magna nunc. Donec tristique enim at mollis commodo. In pharetra, leo eu scelerisque elementum, lacus lectus vulputate massa, ac rhoncus arcu neque non felis. Etiam vel convallis lorem. Quisque sit amet laoreet quam. Nunc sollicitudin tincidunt ante id finibus. Maecenas facilisis nisi sit amet ante euismod, quis cursus sem ullamcorper. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam at mattis massa, at auctor orci.',
        'post 7 title', 1),
       ('Etiam velit ligula, ullamcorper at lectus eu, volutpat gravida massa. Nunc interdum vestibulum malesuada. Integer ac nibh eu ipsum varius scelerisque. Nam nec metus diam. Duis lobortis mauris magna, id scelerisque massa feugiat id. Curabitur laoreet placerat dui non tristique. Aenean vitae turpis eu felis euismod pulvinar et vitae nisi. Donec sollicitudin lacus sit amet urna ullamcorper aliquam. Morbi porttitor scelerisque sollicitudin. ',
        'post 8 title', 1),
       ('Suspendisse a rhoncus lorem. Nullam ut mi mattis neque convallis egestas. Sed eleifend arcu sed nisl lobortis hendrerit. Nunc mauris elit, sodales pulvinar venenatis id, bibendum eu purus. Sed eget mi fringilla, mattis dolor sed, ultricies turpis. Donec dictum, est non ullamcorper tincidunt, dui tortor auctor enim, at dictum purus nibh ac turpis. Etiam et efficitur ex, sed porta libero. Nullam at ex eget tellus posuere suscipit. Sed tempus consequat risus nec sagittis. ',
        'post 8 title', 1),
       ('Sed id mattis ligula. Nulla non malesuada nunc, vel facilisis quam. Suspendisse ac porttitor ex, vel rhoncus mauris. Maecenas sagittis urna lobortis, varius neque eget, porta lorem. Etiam pretium facilisis suscipit. Nulla mi magna, tristique quis diam vitae, auctor lacinia ipsum. Praesent non ex id purus hendrerit iaculis. Pellentesque pharetra turpis id fringilla condimentum. ',
        'post 9 title', 1),
       ('Donec eu arcu metus. Aenean vitae nunc dolor. Etiam ligula urna, venenatis nec ornare vitae, fringilla sit amet magna. Curabitur pellentesque turpis velit, a interdum magna dignissim in. In ex nisl, volutpat sit amet mauris ac, malesuada consectetur dui. Pellentesque vulputate nibh in elit tempus ornare. Donec in efficitur turpis. Phasellus sodales sollicitudin leo sit amet finibus. Mauris tincidunt at ex eget varius. Fusce semper, orci eget interdum luctus, felis massa faucibus ligula, quis viverra lectus urna pulvinar dolor. Morbi id diam et mauris fermentum elementum vel maximus lacus. Morbi magna leo, aliquet quis consectetur accumsan, imperdiet ut lorem. Pellentesque faucibus nulla orci, in consectetur nulla placerat at. ',
        'post 10 title', 1),
       ('Vestibulum dignissim egestas feugiat. Morbi mollis nulla ex, ac pretium nunc sodales eget. Nullam a tellus placerat, dapibus neque in, maximus felis. Sed ac ullamcorper turpis. Curabitur vestibulum placerat mi, vel vehicula nisl cursus id. Praesent aliquet nisi eu aliquet mollis. Aenean ut odio nisi. Nunc sit amet tellus in arcu tincidunt interdum. Donec quis mi turpis. Pellentesque scelerisque sem justo, eu faucibus ipsum finibus sit amet. Suspendisse lobortis ornare dolor tristique dignissim. Quisque non mauris dolor. ',
        'post 11 title', 1),
       ('In fermentum, tortor vel congue pretium, augue elit imperdiet nisi, sit amet sodales neque mi in augue. Praesent risus est, euismod sit amet justo vitae, pulvinar elementum mauris. Quisque congue, sapien quis porta bibendum, nisl nisi feugiat velit, eu fermentum quam dolor non justo. Nam dignissim ante id risus mattis, eu fringilla velit ultricies. Integer risus lorem, porttitor ut vulputate in, mattis eu ligula. Duis in dolor vitae massa facilisis ornare sit amet id lacus. Etiam posuere, mauris eget efficitur tempor, nibh libero bibendum nibh, ac ultricies turpis massa vitae ex. Curabitur faucibus est vel ligula molestie porttitor. Integer metus tortor, vehicula a ornare sit amet, egestas in purus. Sed tempus tellus nisl. Proin finibus lectus nec venenatis tincidunt. Vivamus euismod non turpis ac tristique. Integer sollicitudin purus lacus, sed pellentesque arcu facilisis at. Aenean consectetur lacus id venenatis ultricies. ',
        'post 12 title', 1);

INSERT INTO comments (content, user_id, post_id)
VALUES ('Some interesting post comment content', 1, 1);

